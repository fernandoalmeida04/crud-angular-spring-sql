import { Component, OnInit } from '@angular/core';
import { Projeto } from '../projeto';
import { ProjectService } from '../project.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-project',
  templateUrl: './update-project.component.html',
  styleUrls: ['./update-project.component.css']
})
export class UpdateProjectComponent implements OnInit{

  id: number;
  projeto: Projeto = new Projeto();
  constructor(private projetoService: ProjectService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.projetoService.getProjectById(this.id).subscribe(data => {
      this.projeto = data;
    }, error => console.log(error));
  }


  onSubmit(){
    this.projetoService.updateProject(this.id, this.projeto).subscribe(data =>{
      this.goToProjectList();
    }, error => console.log(error));
  }

  goToProjectList(){
    this.router.navigate(['/projetos']);
  }
}
