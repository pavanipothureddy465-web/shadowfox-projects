package com.shadowfox.employeeleavemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shadowfox.employeeleavemanagement.entity.LeaveRequest;
import com.shadowfox.employeeleavemanagement.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {

        if (leaveRequest.getStartDate() == null ||
            leaveRequest.getEndDate() == null) {

            throw new IllegalArgumentException(
                "Start date and end date are required.");
        }

        if (leaveRequest.getStartDate().isAfter(leaveRequest.getEndDate())) {

            throw new IllegalArgumentException(
                "Start date cannot be after end date.");
        }

        if (!leaveRequest.getLeaveType().equals("CASUAL") &&
            !leaveRequest.getLeaveType().equals("SICK") &&
            !leaveRequest.getLeaveType().equals("EARNED")) {

            throw new IllegalArgumentException("Invalid leave type.");
        }

        leaveRequest.setStatus("PENDING");

        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id).orElse(null);
    }

    public LeaveRequest updateStatus(Long id, String status) {

        LeaveRequest leaveRequest =
            leaveRequestRepository.findById(id).orElse(null);

        if (leaveRequest != null) {
            leaveRequest.setStatus(status);
            return leaveRequestRepository.save(leaveRequest);
        }

        return null;
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }

    public List<LeaveRequest> getLeaveHistory(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }
}