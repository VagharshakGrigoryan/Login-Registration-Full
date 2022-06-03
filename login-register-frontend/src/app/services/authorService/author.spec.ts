import { Author } from '../../model/author';

describe('Book', () => {
  it('should create an instance', () => {
    expect(new Author()).toBeTruthy();
  });
});
