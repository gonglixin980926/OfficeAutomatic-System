<template>
    <section>
        <el-table :data="tableData" highlight-current-row  @selection-change="handleSelectionChange">
            <el-table-column v-if="isManager()" type="selection" width="55"></el-table-column>
            <el-table-column type="index" width="60"></el-table-column>
            <el-table-column prop="qjUsersName" label="请假人" ></el-table-column>
            <el-table-column prop="qjyy" label="请假类型"></el-table-column>
            <el-table-column prop="ksTime" label="请假开始时间" ></el-table-column>
            <el-table-column prop="jsTime" label="请假结束时间" ></el-table-column>
            <el-table-column prop="qjzt" label="审批状态" ></el-table-column>
            <el-table-column prop="qjms" label="备注" ></el-table-column>
            <el-table-column label="操作"  width="220px" >
                <template scope="scope" >
                    <el-button size="small" @click="dialogVisible=true">详情</el-button>
                    <el-button type="success" v-if="isManager()" size="small" :disabled="buttonAble(scope.row)" @click="handleAgree(scope.row,1)">同意</el-button>
                    <el-button type="danger" v-if="isManager()" size="small" :disabled="buttonAble(scope.row)" @click="handleAgree(scope.row,2)">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-button type="danger" v-if="isManager()" size="small" @click="batchRemoveItem()">批量删除</el-button>

        <el-dialog title="申请详情" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <qjApply @changDialog="closeDialog" ref="applyInfo" @getQjList="getTableData" :applyDetails="applyDetails"></qjApply>
        </el-dialog>
    </section>

</template>

<script>
    import util from "../../../common/js/util";
    import {getQjList,qjBatchRemove,agreeQj} from "../../../api/api";
    import qjApply from "./qjApply";
    export default {
        name: "qjList",
        components:{
            qjApply
        },
        data(){
            return{
                user:sessionStorage.getItem("user"),
                tableData: [],
                ifAdmin: true,
                dialogVisible:false,
                applyDetails:{}
            }
        },
        created(){
            this.getTableData();
        },
        methods:{
            isManager(){
                return util.isManager();
            },
            handleAgree(row,value) {
                console.log(row);
                var params = Object.assign({},row);
                params.qjzt = value===1?'同意':'拒绝';
                // if(value==1) {
                // 	var params = {
                // 		qjId: row.qjId,
                // 		qjzt: '同意'
                // 	}
                // }else{
                // 	var params = {
                // 		qjId: row.qjId,
                // 		qjzt: '拒绝'
                // 	}
                // }
                agreeQj(params).then((res) => {
                    this.$message({
                        message: res.data.msg,
                        type: 'success'
                    });
                    this.getTableData()
                })
            },
            getTableData() {
                var user = sessionStorage.getItem('user');
                user = JSON.parse(user);
                user.permission==='1'?this.ifAdmin = true:this.ifAdmin = false;
                var params = {
                    userId: user.userId
                };
                getQjList(params).then((res) => {
                    this.tableData = res.data
                })
            },
            buttonAble(row) {
                return row.qjzt !== '未审批';
            },
            closeDialog(){
                this.dialogVisible = false;
            },
            handleClose(done){
                done()
            },
            handleSelectionChange(val){
                this.selectList = val;
            },
            batchRemoveItem(){
                qjBatchRemove(this.selectList).then(res=>{
                    alert("删除成功")
                    this.getTableData();
                })
            }
        }
    }
</script>

<style scoped>

</style>