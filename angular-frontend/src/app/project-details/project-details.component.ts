import { Component, OnInit } from '@angular/core';
import { Projeto } from '../projeto';
import { ActivatedRoute } from '@angular/router';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-project-details',
  templateUrl: './project-details.component.html',
  styleUrls: ['./project-details.component.css']
})
export class ProjectDetailsComponent implements OnInit {
  
  id: number;
  project: Projeto;
  constructor(private route: ActivatedRoute, private projectService: ProjectService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    
    this.project = new Projeto();
    this.projectService.getProjectById(this.id).subscribe(data =>{
      this.project = data;
    })
  }
}
