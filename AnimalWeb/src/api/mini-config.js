import request from '@/utils/request'

/**
 * 用户管理部分
 */
 export function getConfigList(data) {
    return request({
      url: '/admin/user/selectByExample',
      method: 'post',
      data
    })
  }
  export function updateConfigById(data) {
    return request({
      url: '/admin/user/update',
      method: 'post',
      data
    })
  }
