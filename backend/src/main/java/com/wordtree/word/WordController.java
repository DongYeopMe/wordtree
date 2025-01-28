package com.wordtree.word;

import com.wordtree.global.ResultCode;
import com.wordtree.global.ResultResponse;
import com.wordtree.word.dto.GetWordRequest;
import com.wordtree.word.dto.WordRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @PostMapping("/add")
    public ResponseEntity<Object> addWord(@RequestBody WordRequest wordRequest){
        wordService.add(wordRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.WORD_ADD_SUCCESS));
    }
    @PatchMapping("/edit")
    public ResponseEntity<Object> editWord(@RequestBody WordRequest wordRequest){
        wordService.edit(wordRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.WORD_EDIT_SUCCESS));
    }
    @GetMapping("/get")
    public ResponseEntity<Object> getWord(GetWordRequest getWordRequest){
        Word repsonse =wordService.getWordOne(getWordRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.WORDLIST_GET_SUCCESS,repsonse));
    }
//    @GetMapping("/get")
//    public ResponseEntity<Object> getAddingList(@RequestParam(defaultValue = "0")int size,
//                                                @RequestParam(defaultValue = "10")int page){
//        List<Word> response = wordService.getWordList()
//        return ResponseEntity.ok(ResultResponse.of(ResultCode.WORDLIST_GET_SUCCESS,));
//    }



}
