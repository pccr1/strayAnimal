import request from '@/utils/request'

/**
 * 用户管理部分
 */
 export function getUserList(data) {
    return request({
      url: '/admin/userInfo/selectByExample',
      method: 'post',
      data
    })
  }
  export function updateUser(data) {
    return request({
      url: '/admin/userInfo/update',
      method: 'post',
      data
    })
  }
  export function insertUser(data) {
    return request({
      url: '/admin/userInfo/add',
      method: 'post',
      data
    })
  }
  export function deleteUser(data) {
    return request({
      url: '/admin/userInfo/delete',
      method: 'post',
      data
    })
  }

export function updatePassWord(data) {
    return request({
      url: '/admin/userInfo/resetPassword',
      method: 'post',
      data
    })
  }
  