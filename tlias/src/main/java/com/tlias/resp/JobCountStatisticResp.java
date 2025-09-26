package com.tlias.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shiyu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobCountStatisticResp {

    List<String> jobList;

    List<Integer> countList;

}
