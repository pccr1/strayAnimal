import request from '@/utils/request'

export function getContentList(data) {
    return request({
      url: '/admin/Content/selectByExample',
      method: 'post',
      data
    })
  }
  export function updateContent(data) {
    return request({
      url: '/admin/Content/update',
      method: 'post',
      data
    })
  }
  export function insertContent(data) {
    return request({
      url: '/admin/Content/insert',
      method: 'post',
      data
    })
  }
  export function deleteContent(data) {
    return request({
      url: '/admin/Content/delete',
      method: 'post',
      data
    })
  }

export function updatePassWord(data) {
    return request({
      url: '/admin/Content/updatePassWord',
      method: 'post',
      data
    })
  }
  