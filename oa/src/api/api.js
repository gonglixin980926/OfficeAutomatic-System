import axios from 'axios';

let base = 'http://localhost:8080';
// let base = 'http://azkz2z.natappfree.cc';


export const requestLogin = params => { return axios.post(`${base}/user/login`, params).then(res => res.data); };
//公告
export const getGg = params => { return axios.post(`${base}/gsxx/gsgg`, params).then(res => res.data); };
//新增公告
export const addGg = params => { return axios.post(`${base}/gsxx/addGg`, params).then(res => res.data); };
//删除公告1
export const delGg = params => { 
    console.log(params);
    return axios.post(`${base}/gsxx/delGg`, params).then(res => res.data); 
};
//项目进度
export const getJd = params => { return axios.post(`${base}/gsxx/xmjd`, params).then(res => res.data); };
//我的任务
export const getRw = params => { return axios.post(`${base}/rwxx/myRw`, params).then(res => res.data); };

//获取用户列表
export const getUserList = () => { return axios.get(`${base}/user/userList`); };

//获取所有用户信息
export const getAllUser = () => {
    let user = JSON.parse(sessionStorage.getItem("user"));
    console.log(user)
    return axios.post(`${base}/user/allUser`,user);
};

//更改/保存用户信息

export const saveUser = params => {return axios.post(`${base}/user/saveUser`,params)};

export const getUserListPage = params => { return axios.get(`${base}/user/listpage`, { params: params }); };

export const removeUser = params => { return axios.post(`${base}/user/removeUser`, {id:params})};

export const delRw = params =>{ return axios.post(`${base}/rwxx/delRw`, params).then(res => res.data); }

export const saveRw = params => axios.post(`${base}/rwxx/saveRw`, params);

export const batchRemoveUser = params => { return axios.post(`${base}/user/batchremove`, params); };

export const allRw = params => axios.post(`${base}/rwxx/allRw`,params);

//删除任务
export const batchRemoveRw = params => {
    console.log(params);
    return axios.post(`${base}/rwxx/batchRemoveRw`, params);
};
//修改任务
export const editUser = params => { return axios.get(`${base}/rwxx/updateRw`, { params: params }); };
//新增任务
export const addUser = params => {
    console.log(params)
    return axios.post(`${base}/rwxx/addRw`, params);
};
//获取请假数据
export const getQjList = params => { return axios.post(`${base}/qjsq/getQjList`, params); };
//请假申请
export const addQj = params => {
    console.log(params);
    return axios.post(`${base}/qjsq/addQj`, params )}
    ;
//请假审批
export const agreeQj = params => { return axios.post(`${base}/qjsq/agreeQj`,  params ); };

export const qjBatchRemove = params => { return axios.post(`${base}/qjsq/qjBatchRemove`,  params ); };
//获取日志
export const getLog = params => { return axios.get(`${base}/rwxx/rzList`, { params: params }); };
//新增日志
export const addLog = params => { return axios.post(`${base}/rwxx/addRz`,  params); };
//获取下载文件信息
export const getDown = params => { return axios.get(`${base}/file/fileList`, { params: params }); };
//下载文件
export const downFile = params => { return axios.get(`${base}/file/download`, { params: params }); };
//删除文件
export const delFile = params => {
    return axios.post(`${base}/file/deleteFile`, params )};
//获取会议室
export const getHys = params => { return axios.get(`${base}/user/getHysList`); };
//编辑会议室信息
export const editHys = params => { return axios.get(`${base}/user/updateHys`)};

export const meetingSave = params =>  axios.post(`${base}/user/meetingSave`,params);

export const meetingBatchRemove = params =>  axios.post(`${base}/user/meetingBatchRemove`,params);
//发送参会短信
export const sendMessage = params => { return axios.post(`${base}/user/kh`,  params); };

//获取设备信息
export const equList = params => axios.post(`${base}/equ/equList`,params);
//
export const equSave = params => axios.post(`${base}/equ/equSave`,params);

export const equBatchRemove = params => axios.post(`${base}/equ/equBatchRemove`,params);

//

//出差列表
export const ccList = params =>  axios.post(`${base}/cc/ccList`,params);

export const ccSave = params => axios.post(`${base}/cc/ccSave`,params);

export const ccBatchRemove = params => axios.post(`${base}/cc/ccBatchRemove`,params);


//公出列表
export const gcList = params => axios.post(`${base}/gc/gcList`,params);

export const gcSave = params => axios.post(`${base}/gc/gcSave`,params);

export const gcBatchRemove = params => axios.post(`${base}/gc/gcBatchRemove`,params);

//加班列表
export const jbList = params => axios.post(`${base}/jb/jbList`,params);

export const jbSave = params => axios.post(`${base}/jb/jbSave`,params);

export const jbBatchRemove = params => axios.post(`${base}/jb/jbBatchRemove`,params);
