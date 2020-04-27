<template>
    <div>
<!--        <el-form>-->
<!--            <el-form-item>-->
<!--                <el-button v-if="user.permission!==3" type="primary" size="small" @click="apply" icon="el-icon-plus">请假申请</el-button>-->
<!--            </el-form-item>-->
<!--        </el-form>-->

            <el-form :model="addForm" label-width="120px" ref="addForm">
                <el-row>
                    <el-col :span="10">
                        <el-form-item label="请假人" prop="UserName">
                            <el-input v-model="addForm.userName" ></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row>
                    <el-col :span="10">
                        <el-form-item label="请假原因" prop="UserName">
                            <el-select v-model="addForm.qjyy" >
                                <el-option label="病假" value="病假"></el-option>
                                <el-option label="事假" value="事假"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="10">
                        <el-form-item label="请假时间" prop="UserName">
                            <el-date-picker
                                    v-model="addForm.time"
                                    type="daterange"
                                    value-format="yyyy-MM-dd"
                                    range-separator="至"
                                    start-placeholder="开始日期"
                                    end-placeholder="结束日期">
                            </el-date-picker>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="20">
                        <el-form-item label="备注">
                            <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="addForm.qjms"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col>
                        <el-form-item>
                            <el-button type="primary" @click="addSubmit">立即创建</el-button>
                            <el-button>取消</el-button>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">

            </div>
    </div>
</template>

<script>
    import util from './../../../common/js/util'
    import { getQjList,agreeQj,addQj } from './../../../api/api'
    export default {
        name:'qjApply',
        data() {
            return {
                user:sessionStorage.getItem("user"),
                tableData: [],
                ifAdmin: true,
                addFormVisible: false,
                addForm: {
                    userName: '',
                    qjyy: '',
                    time: '',
                    qjms: ''
                }
            }
        },
        mounted() {
            this.getTableData()
        },
        methods: {
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
                        // type: 'success'
                    });
                    this.getTableData()
                })
            },
            getTableData() {
                var user = sessionStorage.getItem('user');
                user = JSON.parse(user)
                user.permission=='1'?this.ifAdmin = true:this.ifAdmin = false
                var params = {
                    userId: user.userId
                }
                getQjList(params).then((res) => {
                    this.tableData = res.data
                })
            },
            buttonAble(row) {
                if(row.qjzt=='未审批') {
                    return false
                } else {
                    return true
                }
            },
            apply() {
                var user = sessionStorage.getItem('user');
                user = JSON.parse(user)
                this.addFormVisible = true
                this.addForm.userName = user.userName
                this.addForm.qjyy = ''
                this.addForm.time = ''
                this.addForm.qjms = ''
            },
            addSubmit() {
                var user = sessionStorage.getItem('user');
                user = JSON.parse(user)
                var obj = {
                    qjUserId: user.userId,
                    qjUsersName:user.userName,
                    qjyy: this.addForm.qjyy,
                    // ksTime: this.addForm.time[0].valueOf(),
                    ksTime: (!this.addForm.time[0] || this.addForm.time[0] == '') ? '' : util.formatDate.format(new Date(this.addForm.time[0]), 'yyyy-MM-dd'),
                    // jsTime: this.addForm.time[1].valueOf(),
                    jsTime: (!this.addForm.time[1] || this.addForm.time[1] == '') ? '' : util.formatDate.format(new Date(this.addForm.time[1]), 'yyyy-MM-dd'),
                    qjzt: '未审批',
                    qjms: this.addForm.qjms
                }
                addQj(obj).then((res) => {
                    this.$message({
                        message: "申请成功",
                        type: 'success'
                    });
                    this.addFormVisible = false
                    this.getTableData()
                })
            }
        }
    }

</script>