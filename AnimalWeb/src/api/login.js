import request from '@/utils/request'

export function login(data) {
    return request({
      url: '/admin/userInfo/login',
      method: 'post',
      data
    })
  }
  
  // export function getUserInfo(data) {
  //   return request({
  //     url: '/user/detail',
  //     method: 'get',
  //     params: data
  //   })
  // }
  
  export function logout() {
    return request({
      url: '/admin/userInfo/logOut',
      method: 'POST'
    })
  }