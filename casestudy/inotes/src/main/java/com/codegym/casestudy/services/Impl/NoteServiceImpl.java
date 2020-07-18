package com.codegym.casestudy.services.Impl;

import com.codegym.casestudy.models.Note;
import com.codegym.casestudy.repositories.NoteRepository;
import com.codegym.casestudy.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    @Override
    public Page<Note> getAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> getAllByTitle(String title, Pageable pageable){
        return noteRepository.getAllByTitleContaining(title,pageable);
    }

    @Override
    public Note getNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

//    @Override
//    public void writeCsv(List<Note> notes) {
//        try {
//            Writer writer = new PrintWriter(PATH_FILE_NOTES);
//            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_NOTES));
//            if (notes != null) {
//                for (Note note : notes) {
//                    csvPrinter.printRecord(Arrays.asList(note.getId(), note.getTitle(), note.getContent(), note.getNoteType().getId()
//                            , note.getNoteType().getName()));
//                }
//            }
//            csvPrinter.flush();
//            csvPrinter.close();
//            writer.close();
//            System.out.println("Write csv file by using new Apache lib successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
