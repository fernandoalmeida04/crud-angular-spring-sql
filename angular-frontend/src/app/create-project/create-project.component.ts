import { Component, OnInit } from '@angular/core';
import { Projeto } from '../projeto';
import { ProjectService } from '../project.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-project',
  templateUrl: './create-project.component.html',
  styleUrls: ['./create-project.component.css']
})
export class CreateProjectComponent implements OnInit{


  projeto: Projeto = new Projeto();
  constructor(private projectService: ProjectService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveProject(){
    this.projectService.createProject(this.projeto).subscribe(data =>{
      console.log(data)
      this.goToProjectList();
    },
    error => console.log(error));
  }

  goToProjectList(){
    this.router.navigate(['/projetos']);
  }

  onSubmit(){
    console.log(this.projeto);
    this.saveProject();
  }
}
