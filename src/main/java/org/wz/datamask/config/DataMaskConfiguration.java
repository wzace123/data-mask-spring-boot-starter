package org.wz.datamask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wz.datamask.advice.DataMaskAdvice;
import org.wz.datamask.handle.DataMaskHandlerSelector;
import org.wz.datamask.handle.impl.AddressHandler;
import org.wz.datamask.handle.impl.IdCardNumHandler;
import org.wz.datamask.handle.impl.MobileHandler;
import org.wz.datamask.handle.impl.UserNameHandler;
import org.wz.datamask.util.DataMaskUtil;

/**
 * Data Mask Configuration
 */
@Configuration
public class DataMaskConfiguration {

    @Bean
    public AddressHandler addressHandler() {
        return new AddressHandler();
    }

    @Bean
    public IdCardNumHandler idCardNumHandler() {
        return new IdCardNumHandler();
    }

    @Bean
    public MobileHandler mobileHandler() {
        return new MobileHandler();
    }

    @Bean
    public UserNameHandler userNameHandler() {
        return new UserNameHandler();
    }

    @Bean
    public DataMaskHandlerSelector dataMaskHandlerSelector() {
        return new DataMaskHandlerSelector();
    }

    @Bean
    public DataMaskUtil dataMaskUtil(DataMaskHandlerSelector dataMaskHandlerSelector) {
        return new DataMaskUtil(dataMaskHandlerSelector);
    }

    @Bean
    public DataMaskAdvice dataMaskAdvice(DataMaskUtil dataMaskUtil) {
        return new DataMaskAdvice(dataMaskUtil);
    }

}
