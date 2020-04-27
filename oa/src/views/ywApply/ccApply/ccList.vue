<template>
    <div>
        <el-table :data="tableData" highlight-current-row  @selection-change="handleSelectionChange">
            <el-table-column v-if="isManager()" type="selection" width="55"></el-table-column>
            <el-table-column type="index" width="60"></el-table-column>
            <el-table-column prop="applyName" label="申请人" ></el-table-column>
<!--            <el-table-column prop="qjyy" label="部门"></el-table-column>-->
            <el-table-column prop="dest" label="目的地" ></el-table-column>
            <el-table-column prop="customer" label="客户名称" ></el-table-column>
            <el-table-column prop="applyReason" label="出差事由" ></el-table-column>
            <el-table-column prop="reMark" label="备注" ></el-table-column>
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
            <ccApply @changDialog="closeDialog" ref="applyInfo" @getCcList="getCcList" :applyDetails="applyDetails"></ccApply>
        </el-dialog>

    </div>
</template>

<script>
    import util from "../../../common/js/util";
    import {ccList,ccSave,ccBatchRemove} from "../../../api/api";
    import ccApply from "./ccApply";
    export default {
        name: "ccList",
        components:{
            ccApply
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
           this.getCcList()
        },
        methods:{
            isManager(){
                return util.isManager();
            },
            getCcList(){
                let para = {
                    applyName:this.userInfo.userName
                }
                ccList(para).then(res=>{
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
                ccSave(res).then(()=>{
                    alert("审批成功")
                    this.getCcList()
                })
            },
            handleSelectionChange(val){
                this.selectList = val;
            },
            batchRemoveItem(){
               ccBatchRemove(this.selectList).then(res=>{
                    alert("删除成功")
                    this.getCcList();
                })
            }
        }
    }
</script>

<style scoped>

</style>