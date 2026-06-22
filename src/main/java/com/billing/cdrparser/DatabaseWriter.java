/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.billing.cdrparser;

import com.telecom.billing.db.tables.*;
import java.util.List;
import org.jooq.DSLContext;

/**
 *
 * @author seif
 */
public class DatabaseWriter {
    private static final Cdr CDR = Cdr.CDR;
    
    public static boolean write(List<LineItem> items, DSLContext ctx){
        
        for(LineItem item:items){
                ctx.insertInto(CDR)
                    .set(CDR.CONTRACT_ID,item.getContractId())
                    .set(CDR.DIAL_A, item.getDialA())
                    .set(CDR.DIAL_B, item.getDialB())
                    .set(CDR.DURATION, item.getDuration())
                    .set(CDR.EXTERNAL_FEE_PIASTERS, item.getExternalFeePiasters())
                    .set(CDR.SERVICE_TYPE, item.getServiceType())
                    .set(CDR.START_TIME, item.getStartTime())
                    .set(CDR.IS_RATED, item.isRated());
        }
        return true;
    }
}
