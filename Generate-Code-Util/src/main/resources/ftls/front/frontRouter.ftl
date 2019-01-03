export default function (WMS_URL) {
  return {
  	${packName}Index: WMS_URL + '/wms/v1/${packName}/queryWithPage',
  	${packName}Detail: WMS_URL + '/wms/v1/${packName}/{${packName}Id}',
  	${packName}Add: WMS_URL + '/wms/v1/${packName}/save',
  	${packName}Edit: WMS_URL + '/wms/v1/${packName}/{${packName}Id}',
  }
}
