import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProjetoListComponent } from './projeto-list/projeto-list.component';
import { CreateProjectComponent } from './create-project/create-project.component';
import { UpdateProjectComponent } from './update-project/update-project.component';
import { ProjectDetailsComponent } from './project-details/project-details.component';

const routes: Routes = [
  {path: "projetos", component: ProjetoListComponent},
  {path: "create-project", component: CreateProjectComponent},
  {path: "", redirectTo: "projetos", pathMatch: "full"},
  {path: "update-project/:id", component: UpdateProjectComponent},
  {path: "project-details/:id", component: ProjectDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
