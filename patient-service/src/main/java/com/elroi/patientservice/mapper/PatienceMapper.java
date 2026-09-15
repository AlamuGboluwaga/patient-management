package com.elroi.patientservice.mapper;

/**
 * Backwards-compatibility shim: keep the old name but delegate to the new PatientMapper.
 * Marked as deprecated to encourage migration to PatientMapper.
 */
@Deprecated
public interface PatienceMapper extends PatientMapper {
}

