import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { IBizSysModule } from '../../../ibizsys/ibizsys.module';
import { UserModule } from '../../user.module';
import { OA_CLWXSHJSMobEditView } from './oa-clwxshjsmob-edit-view';




@NgModule({
  declarations: [
    OA_CLWXSHJSMobEditView,
  ],
  imports: [
    IonicPageModule.forChild(OA_CLWXSHJSMobEditView),
    IBizSysModule,
    UserModule,
  ],
})
export class OA_CLWXSHJSMobEditViewModule {}