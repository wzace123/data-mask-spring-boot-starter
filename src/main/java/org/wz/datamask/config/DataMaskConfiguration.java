package org.wz.datamask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.wz.datamask.advice.DataMaskAdvice;
import org.wz.datamask.handle.DataMaskHandlerSelector;
import org.wz.datamask.handle.impl.AddressMaskHandler;
import org.wz.datamask.handle.impl.BankCardMaskHandler;
import org.wz.datamask.handle.impl.CarLicenseMaskHandler;
import org.wz.datamask.handle.impl.EmailMaskHandler;
import org.wz.datamask.handle.impl.FixedPhoneMaskHandler;
import org.wz.datamask.handle.impl.IdCardNumMaskHandler;
import org.wz.datamask.handle.impl.Ipv4MaskHandler;
import org.wz.datamask.handle.impl.Ipv6MaskHandler;
import org.wz.datamask.handle.impl.MobilePhoneMaskHandler;
import org.wz.datamask.handle.impl.PasswordMaskHandler;
import org.wz.datamask.handle.impl.UserNameMaskHandler;
import org.wz.datamask.util.DataMaskUtil;

/**
 * Data Mask Configuration
 */
@Configuration
public class DataMaskConfiguration {

    @Bean
    public AddressMaskHandler addressHandler() {
        return new AddressMaskHandler();
    }

    @Bean
    public IdCardNumMaskHandler idCardNumHandler() {
        return new IdCardNumMaskHandler();
    }

    @Bean
    public MobilePhoneMaskHandler mobileHandler() {
        return new MobilePhoneMaskHandler();
    }

    @Bean
    public UserNameMaskHandler userNameHandler() {
        return new UserNameMaskHandler();
    }

    @Bean
    public BankCardMaskHandler bankCardMaskHandler() {
        return new BankCardMaskHandler();
    }

    @Bean
    public CarLicenseMaskHandler carLicenseMaskHandler() {
        return new CarLicenseMaskHandler();
    }

    @Bean
    public EmailMaskHandler emailMaskHandler() {
        return new EmailMaskHandler();
    }

    @Bean
    public FixedPhoneMaskHandler fixedPhoneMaskHandler() {
        return new FixedPhoneMaskHandler();
    }

    @Bean
    public Ipv4MaskHandler ipv4MaskHandler() {
        return new Ipv4MaskHandler();
    }

    @Bean
    public Ipv6MaskHandler ipv6MaskHandler() {
        return new Ipv6MaskHandler();
    }

    @Bean
    public PasswordMaskHandler passwordMaskHandler() {
        return new PasswordMaskHandler();
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
