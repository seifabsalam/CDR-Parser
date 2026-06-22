package com.billing.cdrparser;

import com.telecom.billing.db.tables.*;
import java.util.List;
import org.jooq.DSLContext;

public class DatabaseWriter {
    private static final Cdr CDR = Cdr.CDR;

    public static void write(List<LineItem> items, DSLContext ctx) {
        for (LineItem item : items) {
            ctx.insertInto(CDR)
                    .set(CDR.CONTRACT_ID, item.getContractId())
                    .set(CDR.DIAL_A, item.getDialA())
                    .set(CDR.DIAL_B, item.getDialB())
                    .set(CDR.DURATION, item.getDuration())
                    .set(CDR.EXTERNAL_FEE_PIASTERS, item.getExternalFeePiasters())
                    .set(CDR.SERVICE_TYPE, item.getServiceType())
                    .set(CDR.START_TIME, item.getStartTime())
                    .set(CDR.IS_RATED, item.isRated())
                    .execute();
        }
    }
}
