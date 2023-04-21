import request from '@/utils/request'
export function selectVoluntaryActivityInfo(data) {
    return request({
      url: '/voluntaryActivity/info/selectVoluntaryActivityInfo',
      method: 'post',
      data
    })
  }

  export function selectVoluntaryActivityDetailedInformation(data) {
    return request({
      url: '/voluntaryActivity/info/selectVoluntaryActivityDetailedInformation',
      method: 'post',
      data
    })
  }

  export function selectVolunteer(data) {
    return request({
      url: '/voluntaryActivity/info/selectVolunteer',
      method: 'post',
      data
    })
  }
  export function addVoluntaryActivity(data) {
    return request({
      url: '/voluntaryActivity/info/addVoluntaryActivity',
      method: 'post',
      data
    })
  }
  export function addVolunteer(data) {
    return request({
      url: '/voluntaryActivity/info/addVolunteer',
      method: 'post',
      data
    })
  }
  export function deleteVoluntaryActivity(data) {
    return request({
      url: '/voluntaryActivity/info/deleteVoluntaryActivity',
      method: 'post',
      data
    })
  }
  export function deleteVolunteer(data) {
    return request({
      url: '/voluntaryActivity/info/deleteVolunteer',
      method: 'post',
      data
    })
  }
  export function updateVoluntaryActivity(data) {
    return request({
      url: '/voluntaryActivity/info/updateVoluntaryActivity',
      method: 'post',
      data
    })
  }