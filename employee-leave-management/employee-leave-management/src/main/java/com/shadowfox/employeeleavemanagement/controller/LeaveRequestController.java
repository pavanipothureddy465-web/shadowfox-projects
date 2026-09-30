package com.shadowfox.employeeleavemanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shadowfox.employeeleavemanagement.entity.LeaveRequest;
import com.shadowfox.employeeleavemanagement.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.createLeaveRequest(leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestService.getAllLeaveRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getLeaveRequestById(@PathVariable Long id) {
        return leaveRequestService.getLeaveRequestById(id);
    }

    @PutMapping("/{id}/approve")
    public LeaveRequest approveLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.updateStatus(id, "APPROVED");
    }

    @PutMapping("/{id}/reject")
    public LeaveRequest rejectLeaveRequest(@PathVariable Long id) {
        return leaveRequestService.updateStatus(id, "REJECTED");
    }

    @GetMapping("/employee/{employeeId}")
    public List<LeaveRequest> getLeaveHistory(@PathVariable Long employeeId) {
        return leaveRequestService.getLeaveHistory(employeeId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}