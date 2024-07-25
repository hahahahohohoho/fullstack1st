package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepo;
	
	public List<Board> getBoards() {
		return boardRepo.findAll();
	}
	
	public Board getBoard(Long id) {
		return boardRepo.findById(id).get();
	}

	public Board addBoard(Board board) {
		boardRepo.save(board);
		return board;
	}

	public Board deleteBoard(Long id) {
		boardRepo.deleteById(id);
		return null;
	}
}
