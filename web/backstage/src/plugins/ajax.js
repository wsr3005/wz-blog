// 简单的封装一下axios请求
import axios from 'axios'

const service = axios.create({
  baseURL: process.env.VUE_APP_BASE_API // 默认所有请求地址添加baseurl
  // baseURL: "/front",
})

// 外部使用axios
export default function ajax (url, data = {}, type = 'get') {
  if ((type).toLocaleLowerCase() === 'get') { // get请求
    return service({
      url,
      method: type,
      params: data
    })
  } else if ((type).toLocaleLowerCase() === 'post') { // post请求
    return service({
      url,
      method: type,
      data
    })
  } else { // delete/put请求
    return service({
      url,
      method: type,
      params: data
    })
  }
}
