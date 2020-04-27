<template>
    <div>
        <el-table :data="tableData" highlight-current-row v-loading="false" @selection-change="selsChange" max-height="500" style="width: 100%;">
            <el-table-column type="selection">
            </el-table-column>
            <el-table-column type="index" >
            </el-table-column>
            <el-table-column prop="jsUserName" label="接收人"  sortable>
            </el-table-column>
            <el-table-column prop="fbUserName" label="发布人"  sortable>
            </el-table-column>
            <el-table-column prop="rwmc" label="任务名" >
            </el-table-column>
            <el-table-column prop="jjcd" label="任务紧急程度"  :formatter="formatUrgent" >
            </el-table-column>
            <el-table-column prop="rwTime" label="截止时间" >
            </el-table-column>
            <el-table-column prop="state" label="任务状态" >
            </el-table-column>
            <!-- <el-table-column prop="rwms" label="任务描述">
            </el-table-column> -->
            <el-table-column label="操作" >
                <template scope="scope">
                    <el-button size="small" @click="handleEdit( scope.row)">详情</el-button>
                    <el-button type="primary" :disabled="scope.row.state==='已完成'" size="small" @click="doneRw(scope.row)">完成</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-button type="danger" size="small" @click="batchRemoveItem()">批量删除</el-button>


        <el-dialog title="申请详情" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <rwApply @changDialog="closeDialog" ref="applyInfo" @getRwList="getRwList" :applyDetails="applyDetails"></rwApply>
        </el-dialog>
    </div>


</template>

<script>
    import {allRw, batchRemoveRw, saveRw} from "../../api/api";
    import rwApply from "./rwApply";
    export default {
        name: "rwList",
        components:{
          rwApply
        },
        data(){
            return {
                users:{},
                tableData:[],
                selRwList:[],
                dialogVisible:false,
                applyDetails:{}
            }
        },
        created() {
           this.getRwList()
        },
        methods:{
            getRwList(){
                allRw({}).then(res=>{
                    this.tableData = res.data
                })
            },
            formatUrgent(row) {
                if(row.jjcd === 1) {
                    return '紧急'
                }else if(row.jjcd === 2) {
                    return '适中'
                }else if(row.jjcd === 3) {
                    return '不紧急'
                }
            },
            selsChange(val){
                this.selRwList = val;
            },
            doneRw(val){
                let req = Object.assign({},val);
                req.state = "已完成";
                saveRw(req).then(()=>{
                    alert("保存成功")
                    this.getRwList()
                })
            },
            closeDialog(){
                this.dialogVisible = false
            },
            handleClose(done){
                done();
            },
            batchRemoveItem(){
                batchRemoveRw(this.selRwList).then(()=>{
                    alert("删除成功");
                    this.getRwList();
                })
            },
            handleEdit(row){
                this.dialogVisible = true
                this.applyDetails = row;
            }
        }
    }
</script>

<style scoped>

</style>