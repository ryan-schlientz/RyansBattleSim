import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { HomeComponent } from './Components/home/home.component';
import { RegisterComponent } from './Components/register/register.component';
import { HelpComponent } from './Components/help/help.component';
import { MyAccountComponent } from './Components/my-account/my-account.component';
import { BattleComponent } from './Components/battle/battle.component';
import { CreateCharacterComponent } from './Components/create-character/create-character.component';
import { DeleteCharacterComponent } from './Components/delete-character/delete-character.component';
import { ManageInventoryComponent } from './Components/manage-inventory/manage-inventory.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    HelpComponent,
    MyAccountComponent,
    BattleComponent,
    CreateCharacterComponent,
    DeleteCharacterComponent,
    ManageInventoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
