<template>
    <el-form :model="addForm" label-width="100px" :rules="addForm" ref="addForm">
        <el-row>
            <el-col>
                <el-form-item label="接收人" >
                    <el-select v-model="addForm.jsUserName">
                        <el-option
                                v-for="item in userList"
                                :key="item.userId"
                                :label="item.userName"
                                :value="item.userName">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="7">
                <el-form-item label="任务名">
                    <el-input v-model="addForm.rwmc"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="任务紧急程度">
                    <el-select v-model="addForm.jjcd">
                        <el-option label="紧急" value="1"></el-option>
                        <el-option label="适中" value="2"></el-option>
                        <el-option label="不紧急" value="3"></el-option>
                    </el-select>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col>
                <el-form-item label="截止时间">
                    <el-date-picker type="date" placeholder="选择日期" v-model="endTime"></el-date-picker>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row>
            <el-col :span="7">
                <el-form-item label="任务描述">
                    <el-input type="textarea" :autosize="{minRows:6,maxRows:8}" v-model="addForm.rwms"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <el-row>
            <el-col>
                <el-form-item>
                    <el-button type="primary" @click="onSubmit">立即创建</el-button>
                </el-form-item>
            </el-col>
        </el-row>
    </el-form>

</template>

<script>
    import {getRw,getUserList,addRw} from "../../api/api";

    export default {
        props:["applyDetails"],
        name: "newRw",
        data(){
            return{
                userInfo : JSON.parse(sessionStorage.getItem("user")),
                addForm:{},
                userData:[],
                userList:[],
                endTime:'',
                submit:{}
            }
        },
        mounted() {
            let applyInfo = this._props.applyDetails;
            if (applyInfo){
                this.addForm = Object.assign({},applyInfo);
                console.log(applyInfo)
                this.endTime = applyInfo.rwTime
            }
            var user = sessionStorage.getItem('user');
            user = JSON.parse(user)
            user.permission==1?this.ifAdmin = true:this.ifAdmin = false
            this.getUsers();
            this.getUserList();
        },
        methods:{
            findUserName(userId){
                let arr =  this.userData.filter((item)=>{
                    return item.userId === userId;
                });
                return arr[0].userName;
            },
            getUsers() {
                var user = sessionStorage.getItem('user');
                user = JSON.parse(user)
                let para = {
                    jsUserId: user.userId,
                    // rwmc: this.filters.name
                };
                console.log(para)
                this.listLoading = true;
                //NProgress.start();
                getRw(para).then((res) => {
                    console.log(res)
                    // this.total = res.data.total;
                    this.users = res;
                    this.listLoading = false;
                    //NProgress.done();
                });
            },
            onSubmit(){
                console.log(this.addForm)
                this.addForm["fbUserName"] = this.userInfo.userName
                this.addForm["rwTime"] = this.endTime;
                this.addForm["state"] = "未完成";
                console.log(this.addForm);
                addRw(this.addForm).then(res=>{
                    alert("保存成功")
                })
            },
            //获取接收人list
            getUserList() {
                getUserList().then((res) => {
                    console.log(res,'res')
                    this.userList = res.data
                })
            },
        }
    }
</script>

<style scoped>

</style>