package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public List<AuthorDTO> getAllAuthors() {
        var authors = authorRepository.findAll()
                .stream()
                .map(a -> authorMapper.map(a))
                .toList();
        return authors;

    }

    public AuthorDTO createAuthor(AuthorCreateDTO data) {
        var author = authorMapper.map(data);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public AuthorDTO findAuthorById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id "+ id +" not found"));
        return authorMapper.map(author);
    }

    public AuthorDTO updateAuthor(AuthorUpdateDTO data, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author with id "+ id +" not found"));
        authorMapper.update(data, author);
        authorRepository.save(author);
        return authorMapper.map(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
