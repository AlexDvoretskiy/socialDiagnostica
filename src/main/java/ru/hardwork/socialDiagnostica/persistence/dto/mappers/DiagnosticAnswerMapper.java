package ru.hardwork.socialDiagnostica.persistence.dto.mappers;


import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import ru.hardwork.socialDiagnostica.persistence.dto.DiagnosticAnswerDto;
import ru.hardwork.socialDiagnostica.persistence.entities.data.DiagnosticAnswer;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class DiagnosticAnswerMapper {

	public List<DiagnosticAnswerDto> mapDiagnosticAnswerToDto(List<DiagnosticAnswer> diagnosticAnswers) {
		List<DiagnosticAnswerDto> diagnosticAnswerDtos = new ArrayList<>();

		for (DiagnosticAnswer diagnosticAnswer : diagnosticAnswers) {
			diagnosticAnswerDtos.add(mapDiagnosticAnswerToDto(diagnosticAnswer));
		}
		return diagnosticAnswerDtos;
	}

	public DiagnosticAnswerDto mapDiagnosticAnswerToDto(DiagnosticAnswer diagnosticAnswer) {
		return DiagnosticAnswerDto.builder()
				.description(diagnosticAnswer.getDescription())
				.cost(diagnosticAnswer.getCost())
		.build();
	}
}
