package com.gordon.flowable;

import org.flowable.common.engine.impl.interceptor.Command;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.variable.api.history.HistoricVariableInstance;

import org.flowable.variable.service.impl.persistence.entity.HistoricVariableInstanceEntity;
import org.flowable.variable.service.impl.persistence.entity.HistoricVariableInstanceEntityManager;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:dongchen
 * @Date: 2022/11/29 21:56
 */
public class SetHistoryVariablesCmd implements Command, Serializable {

	private HistoricVariableInstance historicVariableInstance;
	private String jsonStr;

	public SetHistoryVariablesCmd() {

	}
	@Override
	public Object execute(CommandContext commandContext) {
		HistoricVariableInstanceEntity historicVariableInstanceByVariableInstanceId
				= CommandContextUtil.getHistoricVariableService(commandContext).getHistoricVariableInstance("5006");
		historicVariableInstanceByVariableInstanceId.getByteArrayRef().delete("all");
		//historicVariableInstanceByVariableInstanceId
		return true;
	}
}
