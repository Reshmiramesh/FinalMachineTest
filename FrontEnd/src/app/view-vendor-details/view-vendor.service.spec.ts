import { TestBed } from '@angular/core/testing';

import { ViewVendorService } from './view-vendor.service';

describe('ViewVendorService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewVendorService = TestBed.get(ViewVendorService);
    expect(service).toBeTruthy();
  });
});
