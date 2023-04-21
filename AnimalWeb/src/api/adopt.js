import request from '@/utils/request'
export function selectAdoptInfos(data) {
    return request({
      url: '/animal/info/selectAdoptInfos',
      method: 'post',
      data
    })
  }
  export function selectAdoptInfo(data) {
    return request({
      url: '/animal/info/selectAdoptInfo',
      method: 'post',
      data
    })
  }