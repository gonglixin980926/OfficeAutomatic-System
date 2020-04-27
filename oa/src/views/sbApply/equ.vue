<template>
    <div>
        <sbList :equList="equList" @openDialog="openDialog" @getListData="getListData"></sbList>
        <el-dialog :title="applyType" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
            <sbApply @changDialog="closeDialog" ref="applyInfo" :applyDetails="applyDetails"></sbApply>
        </el-dialog>
    </div>
</template>

<script>
    import sbList from '../../components/sbComponent/sbList'
    import sbApply from "./sbApply";
    import {equList} from "../../api/api";
    export default {
        props:["applyType"],
        name: "equ",
        components:{
            sbList,sbApply
        },
        data(){
            return {
                equList:[],
                dialogVisible:false,
                applyDetails:{}
            }
        },
        created() {
            this.getListData();
        },
        // beforeRouteLeave(to, from, next){
        //     console.log("离开页面")
        //     next()
        // },
        handleClose(){
            this.dialogVisible = true;
        },
        methods:{
            getListData(){
                equList({applyType:this._props.applyType}).then(res=>{
                    this.equList = res.data;
                })
            },
            things(){
                console.log("ss")
            },
            closeDialog(){
                this.dialogVisible = false;
            },
            openDialog(details){
                this.dialogVisible = true;
                this.applyDetails = details;
                console.log(this.applyDetails)
            },
            handleClose(done){
                done()
            },

        }

    }
</script>

<style scoped>

</style>