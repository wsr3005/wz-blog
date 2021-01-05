// import ajax from '@/api/axios'

import hitokoto from '@/api/hitokoto' // hitokoto 接口封装

export const getOneKey = (data) => hitokoto('/', data, 'get') // 首页 hitokoto
