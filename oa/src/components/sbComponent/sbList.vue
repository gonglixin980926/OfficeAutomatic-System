<template>
    <div>
<!--        <router-link ></router-link>-->
        <el-table :data="equList" highlight-current-row  @selection-change="handleSelectionChange" max-height="500" style="width: 100%;">
            <el-table-column v-if="isManager()" type="selection" width="55"></el-table-column>
            <el-table-column type="index" width="60"></el-table-column>
            <el-table-column prop="applyName" label="申请人"  sortable>
            </el-table-column>
            <el-table-column prop="applyReason" label="申请原因"   sortable>
            </el-table-column>
            <el-table-column prop="createTime" label="创建时间"   sortable>
            </el-table-column>
            <el-table-column prop="reMarksOne" label="备注1"   sortable>
            </el-table-column>
            <el-table-column prop="reMarksTwo" label="备注2" sortable>
            </el-table-column>
            <el-table-column prop="state" label="状态"   sortable>
            </el-table-column>
            <!-- <el-table-column prop="rwms" label="任务描述">
            </el-table-column> -->
            <el-table-column label="操作" width="200">
                <template scope="scope">
                    <el-button size="small" @click="details(scope.row)">详情</el-button>
                    <el-button size="small" v-if="isManager()" type="success" :disabled="scope.row.state!=='未审批'" @click="handleEdit(scope.row,0)">同意</el-button>
                    <el-button size="small" v-if="isManager()" type="danger" :disabled="scope.row.state!=='未审批'" @click="handleEdit(scope.row,1)">拒绝</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-button type="danger" size="small" @click="batchRemoveItem()">批量删除</el-button>
    </div>

</template>

<script>
    import {equSave,equBatchRemove} from "../../api/api";
    import util from "../../common/js/util";

    export default {
        props:["equList"],
        name: "sbList",
        data(){
            return{
                selectList:[]
            }
        },
        mounted() {

        },
        methods:{
            isManager(){
                return util.isManager();
            },
            details(row){
                this.$emit('openDialog',row);

            },
            handleEdit(row,handel){
                let res = Object.assign({},row);
                res.state = handel?"已拒绝":"已同意"
                equSave(res).then(res=>{
                    alert("审批成功");
                    this.$emit("getListData")
                })
            },
            handleSelectionChange(val){
                this.selectList = val;
            },
            batchRemoveItem(){
                equBatchRemove(this.selectList).then(res=>{
                    alert("删除成功")
                    this.$emit("getListData")
                })
            }

        }
    }
</script>

<style scoped>

</style>