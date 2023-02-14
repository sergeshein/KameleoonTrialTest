package com.shein.KameleoonTrialTest.service;

import com.shein.KameleoonTrialTest.dto.QuoteDTO;
import com.shein.KameleoonTrialTest.dto.VoteDTO;
import com.shein.KameleoonTrialTest.entity.Quote;
import com.shein.KameleoonTrialTest.entity.User;
import com.shein.KameleoonTrialTest.exceptiom.NotFoundResourseException;
import com.shein.KameleoonTrialTest.reository.QuoteRepository;
import com.shein.KameleoonTrialTest.reository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{

    private final QuoteRepository quoteRepository;
    private final UserRepository userRepository;

    public QuoteServiceImpl(QuoteRepository quoteRepository, UserRepository userRepository) {
        this.quoteRepository = quoteRepository;
        this.userRepository = userRepository;
    }



    @Override
    public Quote createQuote(QuoteDTO quoteDTO) {
        User user = userRepository.findById(quoteDTO.getId()).orElseThrow(() -> new NotFoundResourseException("Пользователь с идентификатором " + quoteDTO.getUser().getId()
                + " не найден!"));
        Quote quote = new Quote();
        quote.setContent(quoteDTO.getContent());
        quote.setUser(user);
        quote.setCreatedAt(LocalDateTime.now());
        quote.setUpdatedAt(LocalDateTime.now());
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Long id, QuoteDTO quoteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(
                ()-> new NotFoundResourseException("Цитата с идентификатором " + id + " не найдена!"));
        quote.setContent(quoteDTO.getContent());
        quote.setUpdatedAt(LocalDateTime.now());
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourseException("Цитата с идентификатором " + id +
                        " не найдена!"));
    }

    @Override
    public void deleteQuote(Long id) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourseException("Цитата с идентификатором " + id + "не найдена!"));
        quoteRepository.delete(quote);
    }



    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }



    @Override
    public List<Quote> getTop10Quotes() {
        return quoteRepository.findTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Quote> getWorst10Quotes() {
        return quoteRepository.findTop10ByOrderByCreatedAtAsc();
    }

    @Override
    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        int randomIndex = (int) (Math.random() * quotes.size());
        return quotes.get(randomIndex);
    }





    @Override
    public Quote downVoteQuote(Long id, VoteDTO voteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourseException("Цитата с идентификатором " + id + " не найдена!"));

        int vote = voteDTO.getVote();
        quote.setVotes(quote.getVotes() - vote);
        return quoteRepository.save(quote);
    }



    @Override
    public Quote upvoteQuote(Long id, VoteDTO voteDTO) {
        Quote quote = quoteRepository.findById(id).orElseThrow(() ->
                new NotFoundResourseException("Цитата с идентификатором " + id + " не найдена!"));

        int vote = voteDTO.getVote();
        quote.setVotes(quote.getVotes() + vote);
        return quoteRepository.save(quote);
    }
}
