<template>
    <div >
        <el-form class="apply-form" :model="submit" label-width="120px" :rules="submit" ref="submit">
            <el-row>
                <el-col :span="10"><el-form-item  label="申请人">
                    <el-input v-model="submit.applyName"></el-input>
                </el-form-item></el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item  label="申请标题">
                        <el-input v-model="submit.applyTitle"></el-input>
                    </el-form-item></el-col>
            </el-row>
            <el-row>
                <el-col :span="10">
                    <el-form-item label="公出时间"> <el-date-picker
                            width="100%"
                            v-model="dataTime"
                            type="daterange"
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期">
                    </el-date-picker></el-form-item>

                </el-col>
            </el-row>

            <el-row>

                <el-col :span="10">
                    <el-form-item label="天数">
                        <el-input v-model="submit.days"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="代理人">
                        <el-input v-model="submit.proxyName"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="20">
                    <el-form-item label="代理事项">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.proxyThings"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>


            <el-row>
                <el-col :span="20">
                    <el-form-item label="备注">
                        <el-input type="textarea" :autosize="{minRows:4,maxRows:6}" v-model="submit.reMarks"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">立即提交</el-button>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>

    </div>
</template>

<script>
    import {gcSave} from "../../../api/api";
    import util from "../../../common/js/util";

    export default {
        props:["applyDetails"],
        name: "qjApply",
        data(){
            return{
                submit:{},
                dataTime:[]
            }
        },
        mounted(){
            let sbInfo = this._props.applyDetails;
            if (sbInfo){
                console.log(sbInfo);
                this.submit = Object.assign({},sbInfo)
                this.dataTime = [sbInfo.startTime,sbInfo.endTime];
            }

        },
        methods:{
            onSubmit(){
                this.submit["startTime"] = this.dataTime[0];
                this.submit["endTime"] = this.dataTime[1];
                this.submit["state"] = "未审批"
                console.log(this.submit);
                gcSave(this.submit).then(res=>{
                    alert("保存成功")
                })
            }
        }
    }
</script>

<style scoped>

</style>