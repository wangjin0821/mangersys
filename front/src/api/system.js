import request from '@/utils/request'

export function getMenuList() {
  return request({
    url: '/menu/list',
    method: 'get'
  })
}

export function deleteMenu(params) {
  return request({
    url: '/menu/delete',
    method: 'post',
    data: params
  })
}

export function saveMenu(params) {
  return request({
    url: '/menu/save',
    method: 'post',
    data: params
  })
}

export function updateMenu(params) {
  return request({
    url: '/menu/update',
    method: 'post',
    data: params
  })
}

export function getUserList(params) {
  return request({
    url: '/user/list',
    method: 'post',
    data: params
  })
}

export function deleteUser(params) {
  return request({
    url: '/user/delete',
    method: 'post',
    data: params
  })
}

export function saveUser(params) {
  return request({
    url: '/user/save',
    method: 'post',
    data: params
  })
}

export function updateUserRole(params) {
  return request({
    url: '/user/updateRole',
    method: 'post',
    data: params
  })
}

export function getUserRoles(params) {
  return request({
    url: '/user/roleList',
    method: 'get',
    params
  })
}

export function getRoleList() {
  return request({
    url: '/role/list',
    method: 'get'
  })
}
