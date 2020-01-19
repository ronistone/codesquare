import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanetUpdateComponent } from './planet-update.component';

describe('PlanetUpdateComponent', () => {
  let component: PlanetUpdateComponent;
  let fixture: ComponentFixture<PlanetUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlanetUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanetUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
