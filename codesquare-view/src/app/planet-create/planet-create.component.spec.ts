import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetCreateComponent } from './planet-create.component';

describe('PlanetCreateComponent', () => {
  let component: PlanetCreateComponent;
  let fixture: ComponentFixture<PlanetCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanetCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanetCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
