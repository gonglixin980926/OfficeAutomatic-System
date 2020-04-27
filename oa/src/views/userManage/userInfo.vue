<template>
    <div>
        <el-button type="primary" v-if="nowUser.permission!==3" size="small" @click="dialogVisible=true">新增用户</el-button>
        <el-table
                :data="userList"
                style="width: 100%">
            <el-table-column
                    prop="userName"
                    label="用户名"
                    >
            </el-table-column>
            <el-table-column
                    prop="nikeName"
                    label="昵称"
                    >
            </el-table-column>
            <el-table-column
                prop="zw"
                label="职务">
            </el-table-column>
            <el-table-column
                prop="phone"
                label="手机号">
        </el-table-column>

            <el-table-column
                    prop="dep"
                    label="部门">
            </el-table-column>

            <el-table-column
                    label="操作">
                <template slot-scope="scope">
                    <el-button
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button v-if="nowUser.permission!==3"
                            size="mini"
                            type="danger"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>


        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="20%"
                :before-close="handleClose">
            <el-form ref="form"  label-width="80px">
                <el-form-item  label="昵称">
                    <el-input v-model="userInfo.nikeName"></el-input>
                </el-form-item>
                <el-form-item label="用户名" >
                    <el-input v-model="userInfo.userName"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input type="password" v-model="userInfo.pwd"></el-input>
                </el-form-item>
                <el-form-item label="手机号" >
                    <el-input type="number" v-model="userInfo.phone"></el-input>
                </el-form-item>
                <el-form-item label="部门" >
                    <el-input type="number" v-model="userInfo.dep"></el-input>
                </el-form-item>
                <el-form-item label="职务">
                    <el-select v-model="userInfo.zw" placeholder="请选择">
                        <el-option
                                v-for="item in zwList"
                                :key="item.value"
                                :value="item.value">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="editUserInfo(userInfo)">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import * as scope from "element-ui";

    import {getAllUser,saveUser,removeUser} from './../../api/api'
    export default {
        name: "userInfo",
        data (){
            return{
                nowUser:JSON.parse(sessionStorage.getItem("user")),
                dialogVisible:false,
                userList:[],
                userInfo:{},
                zwList:[

                ]
            }
        },
        created(){
            this.getUserList();
            console.log(this.nowUser)
            if(this.nowUser.permission === 1){
                this.zwList = [{
                    value:'组长',//2
                },{
                    value:'员工',//3
                }]
            }
            if (this.nowUser.permission !==1){
                this.zwList = [{value:'员工'}]
            }
        },
        mounted() {
        },
        methods:{
            getUserList(){
                getAllUser().then(res=>{
                    this.userList = res.data;
                })
            },
            handleEdit(index,userInfo){
                this.dialogVisible = true;
                this.userInfo = userInfo;
            },
            handleDelete(index,userInfo){
                removeUser(userInfo.userId).then(res=>{
                    console.log(res)
                    this.getUserList();

                })

            },
            handleClose(){
                this.dialogVisible = false;
                this.userInfo={};


            },
            editUserInfo(userInfo){

                switch (userInfo.zw) {
                    case "组长":
                        userInfo.permission = 2
                        break;
                    case "员工":
                        userInfo.permission = 3
                        break;
                }
                saveUser(userInfo).then(res=>{
                    this.getUserList();
                    if (res.data.msg === '保存成功'){
                        this.$message({
                            message: '恭喜你，保存成功',
                            type: 'success'
                        });
                    }else{
                        this.$message({
                            message: '很遗憾，保存失败',
                            type: 'error'
                        });
                    }
                    this.userInfo={};
                    console.log(res)
                });
                this.dialogVisible = false;
            }

        }
    }
</script>

<style scoped>

</style>