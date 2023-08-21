import { Component, OnInit } from '@angular/core';
import { Projeto } from "../projeto"
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-projeto-list',
  templateUrl: './projeto-list.component.html',
  styleUrls: ['./projeto-list.component.css']
})
export class ProjetoListComponent implements OnInit{
  
  projetos: Projeto[];

  constructor(private projetoService : ProjectService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProject();
  }
  
  private getProject(){
    this.projetoService.getProjectList().subscribe(data => {
      this.projetos = data;
    });
  }

  projectDetails(id: number){
    this.router.navigate(['project-details', id]);
  }

  updateProject(id: number){
    this.router.navigate(['update-project', id]);
  }

  deleteProject(id: number){
    this.projetoService.deleteProject(id).subscribe(data =>{
      console.log(data);
      this.getProject();
    })
  }
}
