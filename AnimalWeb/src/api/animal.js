import request from '@/utils/request'
export function getAllAnimalInfo(data) {
    return request({
      url: '/animal/info/getAllAnimalInfo',
      method: 'post',
      data
    })
  }
export function addAnimalInfo(data) {
    return request({
      url: '/animal/info/addAnimalInfo',
      method: 'post',
      data
    })
  }
  export function updateAnimalInfo(data) {
    return request({
      url: '/animal/info/updateAnimalInfo',
      method: 'post',
      data
    })
  }
  export function selectAnimals(data) {
    return request({
      url: '/animal/info/selectAnimals',
      method: 'post',
      data
    })
  }
  export function deleteAnimal(data) {
    return request({
      url: '/animal/info/deleteAnimal',
      method: 'post',
      data
    })
  }
  