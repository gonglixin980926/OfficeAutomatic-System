<template>
    <div>
        <el-table :data="tableData" highlight-current-row  @selection-change="handleSelectionChange">
            <el-table-column v-if="isManager()" type="selection" width="55"></el-table-column>
            <el-table-column type="index" width="60"></el-table-column>
            <el-table-column prop="applyName" label="申请人" ></el-table-column>
            <el-table-column prop="jbTitle" label="申请标题"></el-table-column>
<!--            <el-table-column prop="jsTime" label="加班日期" ></el-table-column>-->
            <el-table-column prop="startTime" label="开始时间" ></el-table-column>
            <el-table-column prop="endTime" label="结束时间" ></el-table-column>
            <el-table-column prop="workContent" label="工作内容" ></el-table-column>
<!--            <el-table-column prop="qjms" label="加班小时数" ></el-table-column>-->
            <el-table-column prop="state" label="审批状态" ></el-table-column>
            <el-table-column label="操作" width="200">
                <template scope="scope">
                    <el-button size="small" @click="details(scope.row)">详情</el-button>
                    <el-button type="success" v-if="isManager()" :disabled="scope.row.state!=='未审批'" size="small" @click="handleEdit(scope.row,0 )">同意</el-button>
                    <el-button type="danger" v-if="isManager()" :disabled="scope.row.state!=='未审批'" size="small" @click="handleEdit(scope.row, 1)">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-button type="danger" size="small" v-if="isManager()" @click="batchRemoveItem()">批量删除</el-button>


        <el-dialog title="申请详情" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <jbApply @changDialog="closeDialog" ref="applyInfo" @getJbList="getJbList" :applyDetails="applyDetails"></jbApply>
        </el-dialog>
    </div>
</template>

<script>
    import util from "../../../common/js/util";
    import {jbList,jbSave,jbBatchRemove} from "../../../api/api";
    import jbApply from "./jbApply";
    export default {
        components:{
            jbApply
        },
        name: "jbList",
        data(){
            return{
                userInfo:JSON.parse(sessionStorage.getItem("user")),
                tableData:[],
                dialogVisible:false,
                applyDetails:{},
                selectList:[]
            }
        },
        created(){
          this.getJbList()
        },
        methods:{
            isManager(){
                return util.isManager();
            },
            getJbList(){
                let para = {
                    applyName:this.userInfo.userName
                }
                jbList(para).then(res=>{
                    this.tableData = res.data
                })
            },
            details(row){
                this.dialogVisible = true
                this.applyDetails = row;
            },
            handleClose(done){
                done()
            },
            closeDialog(){
                this.dialogVisible = false;
            },
            handleEdit(row,handel){
                let res = Object.assign({},row);
                res.state = handel?"已拒绝":"已同意"
                console.log(res)
                jbSave(res).then(()=>{
                    alert("审批成功");
                    this.getJbList();
                })
            },
            handleSelectionChange(val){
                this.selectList = val;
            },
            batchRemoveItem(){
                jbBatchRemove(this.selectList).then(res=>{
                    alert("删除成功")
                    this.getJbList();
                })
            }
        }
    }
</script>

<style scoped>

</style>