/**
 * path.js
 */
export default function (WMS_URL) {
  return {
  	${packName}Index: WMS_URL + '/wms/v1/${packName}/queryWithPage',
  	${packName}Detail: WMS_URL + '/wms/v1/${packName}/{${packName}Id}',
  	${packName}Add: WMS_URL + '/wms/v1/${packName}/save',
  	${packName}Edit: WMS_URL + '/wms/v1/${packName}/{${packName}Id}',
  }
}

/**
 * config
 */
import ${packName} from './children/${packName}.js';

export const API_LIST = {
  ...goodsArriveA(WMS_URL),
};

/**
 * route
 */
import ${packName} from '../pages/${componentPre}/${packName}Index.vue';

const router = new Router({
  routes: [
    {
      path: '/${packName}',
      name: '${packName}',
      component: ${packName}
    }
  ]
});