package ru.hardwork.socialDiagnostica.persistence.dto.mappers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticQuestionDto;
import ru.hardwork.socialDiagnostica.persistence.dto.QuestionTypeDto;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticQuestion;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class DiagnosticQuestionMapper {
	private final DiagnosticAnswerMapper diagnosticAnswerMapper;


	public List<DiagnosticQuestionDto> mapDiagnosticQuestionToDto(List<DiagnosticQuestion> diagnosticQuestions) {
		List<DiagnosticQuestionDto> diagnosticQuestionDtos = new ArrayList<>();

		for (DiagnosticQuestion diagnosticQuestion : diagnosticQuestions) {
			diagnosticQuestionDtos.add(mapDiagnosticQuestionToDto(diagnosticQuestion));
		}
		return diagnosticQuestionDtos;
	}

	public DiagnosticQuestionDto mapDiagnosticQuestionToDto(DiagnosticQuestion diagnosticQuestion) {
		return DiagnosticQuestionDto.builder()
				.questionTypeDto(new QuestionTypeDto(diagnosticQuestion.getQuestionType().getName()))
				.description(diagnosticQuestion.getDescription())
				.duration(diagnosticQuestion.getDuration())
				.diagnosticAnswers(diagnosticAnswerMapper.mapDiagnosticAnswerToDto(diagnosticQuestion.getDiagnosticAnswers()))
		.build();
	}
}
