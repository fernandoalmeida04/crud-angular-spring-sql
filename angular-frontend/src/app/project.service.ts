import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Projeto } from './projeto';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private baseURL = "http://localhost:8080/api/v1/projetos";
  constructor(private httpClient: HttpClient) { }

  getProjectList(): Observable<Projeto[]>{
    return this.httpClient.get<Projeto[]>(`${this.baseURL}`);
  }

  createProject(project: Projeto): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, project)
  }
  
  getProjectById(id: number): Observable<Projeto>{
    return this.httpClient.get<Projeto>(`${this.baseURL}/${id}`);
  }

  updateProject(id: number, projeto: Projeto): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, projeto);
  }

  deleteProject(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
