import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import { HomeComponent } from './Components/home/home.component';
import { HelpComponent } from './Components/help/help.component';
import { MyAccountComponent } from './Components/my-account/my-account.component';
import { BattleComponent } from './Components/battle/battle.component';
import { CreateCharacterComponent } from './Components/create-character/create-character.component';
import { DeleteCharacterComponent } from './Components/delete-character/delete-character.component';
import { ManageInventoryComponent } from './Components/manage-inventory/manage-inventory.component';

const routes: Routes = [
  {path : 'login', component : LoginComponent},
  {path : 'register', component : RegisterComponent},
  {path : 'home', component : HomeComponent},
  {path : 'help', component : HelpComponent},
  {path : 'myAccount', component : MyAccountComponent},
  {path : 'battle', component : BattleComponent},
  {path : 'createCharacter', component : CreateCharacterComponent},
  {path : 'deleteCharacter', component : DeleteCharacterComponent},
  {path : 'manageInventory', component : ManageInventoryComponent},

  {path : '', redirectTo: '/login', pathMatch : 'full'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
