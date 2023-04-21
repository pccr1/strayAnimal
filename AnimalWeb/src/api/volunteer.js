import request from '@/utils/request'
export function getAllVolunteer(data) {
    return request({
      url: '/volunteer/info/getAllVolunteer',
      method: 'post',
      data
    })
  }
  