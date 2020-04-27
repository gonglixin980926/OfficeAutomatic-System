<template>
    <div>
        <el-table :data="tableData" highlight-current-row  @selection-change="handleSelectionChange">
            <el-table-column v-if="isManager()" type="selection" width="55"></el-table-column>
            <el-table-column type="index" width="60"></el-table-column>
            <el-table-column prop="applyName" label="申请人" ></el-table-column>
            <el-table-column prop="applyTitle" label="申请标题" ></el-table-column>
<!--            <el-table-column prop="qjyy" label="申请人职位"></el-table-column>-->
            <el-table-column prop="proxyName" label="代理人" ></el-table-column>
<!--            <el-table-column prop="qjzt" label="部门" ></el-table-column>-->
            <el-table-column prop="startTime" label="开始时间" ></el-table-column>
            <el-table-column prop="endTime" label="结束时间" ></el-table-column>
            <el-table-column prop="days" label="天数" ></el-table-column>
            <el-table-column prop="state" label="审批状态" ></el-table-column>

            <el-table-column label="操作" width="200">
                <template scope="scope">
                    <el-button size="small" @click="details(scope.row)">详情</el-button>
                    <el-button size="small" type="success" v-if="isManager()" :disabled="scope.row.state!=='未审批'" @click="handleEdit(scope.row,0)">同意</el-button>
                    <el-button size="small" type="danger" v-if="isManager()" :disabled="scope.row.state!=='未审批'" @click="handleEdit(scope.row,1)">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-button type="danger" size="small" v-if="isManager()" @click="batchRemoveItem()">批量删除</el-button>

        <el-dialog title="申请详情" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <gcApply @changDialog="closeDialog" ref="applyInfo" @getGcList="getGcList" :applyDetails="applyDetails"></gcApply>
        </el-dialog>
    </div>
</template>

<script>
    import util from "../../../common/js/util";
    import {gcList,gcSave,gcBatchRemove} from "../../../api/api";
    import gcApply from "./gcApply";
    export default {
        name: "gcList",
        components:{
            gcApply
        },
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
          this.getGcList()
        },
        methods:{
            isManager(){
                return util.isManager();
            },
            getGcList(){
                let para = {
                    applyName:this.userInfo.userName
                }
                gcList(para).then(res=>{
                    console.log(res.data);
                    console.log(this.tableData)
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
                gcSave(res).then(()=>{
                    alert("审批成功")
                    this.getGcList()

                })
            },
            handleSelectionChange(val){
                this.selectList = val;
            },
            batchRemoveItem(){
                gcBatchRemove(this.selectList).then(res=>{
                    alert("删除成功")
                    this.getGcList();
                })
            }
        }
    }
</script>

<style scoped>

</style>